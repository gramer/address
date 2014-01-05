Ext.define('Address.model.Address', {
	extend : 'Ext.data.Model',
	requires : [],
	fields : [ {
		name : 'id',
		type : 'string'
	}, {
		name : 'name',
		type : 'string'
	}, {
		name : 'cellPhoneNumber',
		type : 'string'
	}, {
		name : 'email',
		type : 'string'
	} ]
});
