package biz.dfch.j.graylog2.plugin.filter;

import java.util.Collection;
import com.google.common.collect.Lists;
import org.graylog2.plugin.Plugin;
import org.graylog2.plugin.PluginModule;

/**
 * Implement the Plugin interface here.
 */
public class dfchBizAuditLogPlugin implements Plugin {
    @Override
    public Collection<PluginModule> modules () {
        return Lists.newArrayList((PluginModule) new dfchBizAuditLogModule());
    }
}
