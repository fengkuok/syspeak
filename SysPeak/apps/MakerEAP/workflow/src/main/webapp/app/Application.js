/**
 * Main application definition for Docs app.
 *
 * We define our own Application class because this way we can also
 * easily define the dependencies.
 */
Ext.define('Workflow.Application', {
    extend: 'Ext.app.Application',
    name: 'Workflow',

    autoCreateViewport: true,

    launch: function() {
        Workflow.App = this;

        // When google analytics event tracking script present on page
        if (Workflow.initEventTracking) {
            Workflow.initEventTracking();
        }
    }
});
