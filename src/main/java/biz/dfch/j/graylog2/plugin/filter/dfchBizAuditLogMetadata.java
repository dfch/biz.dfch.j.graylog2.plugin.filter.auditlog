package biz.dfch.j.graylog2.plugin.filter;

import org.graylog2.plugin.PluginMetaData;
import org.graylog2.plugin.Version;

import java.net.URI;

/**
 * Implement the PluginMetaData interface here.
 */
public class dfchBizAuditLogMetadata implements PluginMetaData {
    @Override
    public String getUniqueId()
    {
        return "056230e2-8495-42ca-a809-c44ceae3d6df";
    }
    @Override
    public String getName()
    {
        return "d-fens AUDITLOG Filter";
    }
    @Override
    public String getAuthor()
    {
        return "Ronald Rink, d-fens GmbH";
    }
    @Override
    public URI getURL()
    {
        return URI.create("http://www.d-fens.ch");
    }
    @Override
    public Version getVersion()
    {
        return new Version(1, 0, 0);
    }
    @Override
    public String getDescription()
    {
        return "d-fens AUDITLOG Filter. With this plugin you can send messages to another destination.";
    }
    @Override
    public Version getRequiredVersion()
    {
        return new Version(0, 90, 0);
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
