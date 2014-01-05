Ext.define('Address.store.Addresses', {
	requires : [],
	extend : 'Ext.data.Store',
	model : 'Address.model.Address',
	proxy : {
		type : 'ajax',
		url : 'addresses',
		reader : {
			type : 'json'
		}
	}
});
