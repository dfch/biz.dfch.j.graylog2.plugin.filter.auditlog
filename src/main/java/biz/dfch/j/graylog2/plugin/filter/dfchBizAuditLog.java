package biz.dfch.j.graylog2.plugin.filter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import org.graylog2.plugin.configuration.Configuration;
import org.graylog2.plugin.configuration.ConfigurationRequest;
import org.graylog2.plugin.configuration.fields.BooleanField;
import org.graylog2.plugin.configuration.fields.ConfigurationField;
import org.graylog2.plugin.configuration.fields.TextField;
import org.graylog2.plugin.Message;
import org.graylog2.plugin.outputs.*;
import org.graylog2.plugin.filters.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is the plugin. Your class should implement one of the existing plugin
 * interfaces. (i.e. AlarmCallback, MessageInput, MessageOutput)
 */
public class dfchBizAuditLog implements MessageFilter
{
    private static final String DF_PLUGIN_NAME = "d-fens AUDITLOG Filter";
    private static final String DF_PLUGIN_HUMAN_NAME = "biz.dfch.j.graylog2.plugin.filter.auditlog";
    private static final String DF_PLUGIN_DOC_LINK = "https://github.com/dfch/biz.dfch.j.graylog2.plugin.filter.auditlog";
    private static final String DF_PLUGIN_PRIORITY = "DF_PLUGIN_PRIORITY";

    private static final String DF_SCRIPT_ENGINE = "DF_SCRIPT_ENGINE";
    private static final String DF_SCRIPT_PATH_AND_NAME = "DF_SCRIPT_PATH_AND_NAME";
    private static final String DF_DISPLAY_SCRIPT_OUTPUT = "DF_DISPLAY_SCRIPT_OUTPUT";
    private static final String DF_SCRIPT_CACHE_CONTENTS = "DF_SCRIPT_CACHE_CONTENTS";

    private boolean _isRunning = false;
    private Configuration _configuration;

    private ScriptEngineManager _scriptEngineManager;
    private ScriptEngine _scriptEngine;
    private ScriptContext _scriptContext;
    private File _file;
    
    private static final Logger LOG = LoggerFactory.getLogger(dfchBizAuditLog.class);

    private static final Object _lock = new Object();
    private static Message _previousMessage;
    private static List<Message> _messages = new ArrayList<Message>(1000);

    
    @Override
    public boolean filter(Message msg)
    {
        //System.out.printf("*** %s: '%s'\r\n", msg.getId(), msg.getMessage());
        //LOG.trace("*** %s: '%s'\r\n", msg.getId(), msg.getMessage());
        msg.addField("DF_PLUGIN_NAME", DF_PLUGIN_NAME);

        Thread t = Thread.currentThread();
        //System.out.printf("*** _messages.size() %d ***\r\n", _messages.size());
        System.out.printf("*** %s ***  %s @ %x: '%s'\r\n", DF_PLUGIN_NAME, msg.getId(), t.getId(), msg.getMessage());
        synchronized (_lock)
        {
            try
            {
                if(1000 <= _messages.size())
                {
                    _messages.remove(0);
                }
                _messages.add(msg);
                // get avg of all messages
                double cpuAverage = 0;
                for(Message entry : _messages)
                {
                    Number cpu = (Number) entry.getField("cpu");
                    if(null == cpu)
                    {
                        continue;
                    }
                    cpuAverage += cpu.doubleValue();
                }
                cpuAverage /= _messages.size();
                System.out.printf("cpuAverage over the last %d messages: %f\r\n", _messages.size(), cpuAverage);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }

//        if(null != _previousMessage)
//        {
//            System.out.printf("*** DF_PLUGIN_NAME *** PREVIOUS *** %s @ %x: '%s'\r\n", _previousMessage.getId(), t.getId(), _previousMessage.getMessage());
//            try
//            {
//                Map<String, Object> fields = _previousMessage.getFields();
//                for(Map.Entry<String, Object> entry : fields.entrySet())
//                {
//                    System.out.printf("Key '%s', Value '%s'\r\n", entry.getKey(), entry.getValue().toString());
//                }
//            }
//            catch(Exception ex)
//            {
//                ex.printStackTrace();
//            }
//        }
//        System.out.printf("*** DF_PLUGIN_NAME *** CURRENT  *** %s @ %x: '%s'\r\n", msg.getId(), t.getId(), msg.getMessage());
//        try
//        {
//            Map<String, Object> fields = msg.getFields();
//            //_previousMessage = new Message(fields);
//            synchronized (_lock)
//            {
//                _previousMessage = msg;
//            }
//            for(Map.Entry<String, Object> entry : fields.entrySet())
//            {
//                System.out.printf("Key '%s', Value '%s'\r\n", entry.getKey(), entry.getValue().toString());
//            }
//        }
//        catch(Exception ex)
//        {
//            ex.printStackTrace();
//        }

        // TODO 
        // add your code to forward messages to where it is needed
        
        return false;
    }

    @Override
    public String getName()
    {
        return DF_PLUGIN_NAME;
    }
    @Override
    public int getPriority()
    {
        return 0;
    }


}

/**
 *
 *
 * Copyright 2015 Ronald Rink, d-fens GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
