package biz.dfch.j.graylog2.plugin.filter;

import org.graylog2.plugin.PluginModule;

/**
 * Extend the PluginModule abstract class here to add you plugin to the system.
 */
public class dfchBizAuditLogModule extends PluginModule {
    @Override
    protected void configure() {
        registerPlugin(dfchBizAuditLogMetadata.class);

        /* Register your plugin types here.
         *
         * Examples:
         *
         * addMessageInput(Class<? extends MessageInput>);
         * addMessageFilter(Class<? extends MessageFilter>);
         * addMessageOutput(Class<? extends MessageOutput>);
         * addPeriodical(Class<? extends Periodical>);
         * addAlarmCallback(Class<? extends AlarmCallback>);
         * addInitializer(Class<? extends Service>);
         */
    }
}