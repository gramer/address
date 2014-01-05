Ext.define('Address.view.Main', {
	extend : 'Ext.container.Container',
	requires : [ 'Ext.grid.*', 'Ext.layout.container.*' ],

	xtype : 'app-main',

	layout : {
		type : 'vbox',
		align : 'stretch'
	},

	items : [ {
		xtype : 'gridpanel',
		title : '주소록',
		store : Ext.create('Address.store.Addresses'),
		forceFit : true,
		header : true,
		tbar : [ {
			xtype : 'button',
			text : '조회',
			tag : 'search'
		}, {
			xtype : 'button',
			text : '신규',
			tag : 'add'
		}, {
			xtype : 'button',
			text : '저장',
			tag : 'save'
		} ],
		columns : [ {
			text : '이름',
			dataIndex : 'name'
		}, {
			text : '이메일',
			dataIndex : 'email'
		}, {
			text : '전화번호',
			dataIndex : 'cellPhoneNumber'
		} ]
	} ]
});