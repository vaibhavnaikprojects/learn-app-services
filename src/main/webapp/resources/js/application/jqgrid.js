var mydata;
var myjson;
var arr = [ {
	req_id : "ECS73465",
	prod_name : "sakdhfkjd",
	Actions : "dsh"
} ];
$(document)
		.ready(
				function() {
					var g = [ {
						req_id : "ESC73265734",
						prod_name : "dummy",
						eol_reqStatus : "Pending with Layout Vendor"
					}, {
						req_id : "ESC73265734",
						prod_name : "dummy",
						eol_reqStatus : "Posted"
					}, {
						req_id : "ESC73265734",
						prod_name : "dummy",
						eol_reqStatus : "Pending with BU"
					}, {
						req_id : "ESC73265734",
						prod_name : "dummy",
						eol_reqStatus : "Pending with BU"
					}, {
						req_id : "ESC73265734",
						prod_name : "dummy",
						eol_reqStatus : "Pending with BU"
					} ];
					var e = [ {
						req_id : "ECS73465",
						prod_name : "dummy",
						Actions : "dsh"
					}, {
						req_id : "ECS73465",
						prod_name : "sakdhfkjd",
						Actions : "dsh"
					}, {
						req_id : "ECS73465",
						prod_name : "sakdhfkjd",
						Actions : "dsh"
					}, {
						req_id : "ECS73465",
						prod_name : "sakdhfkjd",
						Actions : "dsh"
					}, {
						req_id : "ECS73465",
						prod_name : "sakdhfkjd",
						Actions : "dsh"
					}, {
						req_id : "ECS73465",
						prod_name : "sakdhfkjd",
						Actions : "dsh"
					} ];
					mydata = '{ "data" : [{ "req_id":"ECS1234" , "prod_name":"dummy", "Actions":"none" },{ "req-id":"ECS53645" , "prod_name":"dummy", "Actions":"none" }]}';
					myjson = JSON.parse(mydata);
					console.log(mydata);
					console.log(myjson);
					$("#myTaskJqGrid").jqGrid({
						data : e,
						// toppager : "#myTaskJqGrid" + "_toppager",
						// caption: "<h2><span class='label label-default'>My
						// Tasks</span><h2>",
						datatype : "local",
						colModel : [ {
							label : "Request ID",
							name : "req_id",
							width : 90,
							formatter : f,
							search : false
						}, {
							label : "Product Name",
							name : "prod_name",
							width : 90,
							search : true
						}, {
							label : "Actions",
							name : "Actions",
							formatter : h,
							width : 90,
							search: false
						} ],
						viewrecords : true,
						gridview : true,
						loadonce : false,
						autowidth : true,
						rowNum : 5,
						shrinkToFit : true,
						pager : "#myTaskJqGridPager"
						//toolBar : [ true, "top" ]

					});

					/*
					 * jQuery("#myTaskJqGrid").jqGrid('navGrid', '#myTaskJqGrid' +
					 * '_toppagger', { edit : true, add : true, del : true,
					 * refresh : false, view : true });
					 */
					$("#myTaskJqGrid").jqGrid('navGrid', '#myTaskJqGridPager',
							{
								add : false,
								edit : false,
								del : false,
								reload: true,
								search: false
							});
					$("#myTaskJqGrid").jqGrid('filterToolbar', {
						searchOnEnter : false,
						enableClear : true,
						id:"filter",
						defaultSearch : 'cn',
						ignoreCase : true
					});
					// $("#myTaskJqGrid")[0].toggleToolbar();
					$("#myTaskJqGrid").jqGrid('navButtonAdd',
							'#myTaskJqGridPager', {
								caption : "",
								title : "Toggle Searching Toolbar",
								id: "toggle1",
								buttonicon : 'glyphicon glyphicon-filter',
								onClickButton : function() {
									$("#myTaskJqGrid")[0].toggleToolbar();
								}
							});
					$(".ui-search-toolbar").hide();
					// $('#myTaskJqGrid').jqGrid('filterToolbar', {
					// searchOnEnter: true, enableClear: false });
					// $("#myTaskJqGrid").jqgrid('navButtonAdd', '#' +
					// 'myTaskJqGrid' + '_toppager_left',{caption: "",
					// title: "Save",
					// id: 'save'});

					$("#addEditGrid").jqGrid({
						data : g,
						datatype : "local",
						colModel : [ {
							label : "Select",
							name : "",
							width : 90,
							formatter : 'checkbox',
							edittype : 'checkbox'
						// editable: true
						}, {
							label : "PIDs",
							name : "req_id",
							width : 90,
							formatter : f
						}, {
							label : "Product Type",
							name : "prod_name",
							width : 90
						}, {
							label : "Migration Option",
							name : "eol_reqStatus",
							width : 90
						}, {
							label : "Migration PIDs",
							name : "mig_pid",
							width : 90
						} ],
						viewrecords : true,
						gridview : true,
						loadonce : false,
						autowidth : true,
						rowNum : 5,
						shrinkToFit : true,
						multiselect : true,// for selction
						pager : "#addEditGridPager",
						search : true,
						// toppager:true,
						searchrules : {
							custom : true,
							custom_func : myRequestSearch
						},
						toolbar : [ true, "top" ]
					}).navGrid('#addEditGridPager', {
						add : false,
						edit : false,
						del : false,
						search : false,
						cloneToTop : true
					});
					/*
					 * $("#eolReqJqGrid").inlineNav("#eolReqJqGridPager", { edit :
					 * true, add : true, del : false, refresh : false, view :
					 * false });
					 * $("#myTaskJqGrid").inlineNav("#t_"+"myTaskJqGrid", { edit :
					 * true, add : false, del : false, refresh : false, view :
					 * false });
					 */
					// $('#addEditGrid_pager_left').clone(true).insertBefore('#addEditGrid_toppager_center')
					function myRequestSearch(value, colName) {
						return [ true, "" ];
					}
					function h() {
						return "<div><a href='#'>Reassign</a> <div class = 'glyphicon glyphicon-hand-right'></div></div>"
					}
					function f(b, c, a) {
						return "<div><a href = '#'>" + b + "</a></div>"
					}

				});
function getSelectedRows() {
	var grid = $("#addEditGrid");
	var rowKey = grid.getGridParam("selrow");
	if (!rowKey)
		alert("No rows are selected");
	else {
		var selectedIDs = grid.getGridParam("selarrrow");
		var result = "";
		for (var i = 0; i < selectedIDs.length; i++) {
			result += selectedIDs[i] + ",";
		}

		alert(result);
	}
}