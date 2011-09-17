/**
 * Provides methods dealing with localStorage- and memory-store.
 *
 */
Ext.define("Workflow.cls.LocalStore", {
    storeName: '',

    /**
     * Initializes store management.
     *
     * Initializes this.store variable and loads the store if
     * localStorage available.
     */
    init: function() {
        this.localStorage = ('localStorage' in window && window['localStorage'] !== null);
        this.store = Ext.getStore(this.storeName);
        this.localStorage && this.store.load();
    },

    /**
     * Syncs the store with localStorage if possible.
     */
    syncStore: function() {
        this.localStorage && this.store.sync();
    }

});
