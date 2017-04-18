$(document).ready(
				function() {
					$.getJSON('static/json/areas.json',
							function(data) {

								/**重定义数据结构**/
								/**
								 * id 键,name 名字,level 层级,parentId 父级
								 */
								for (var i = 0; i < data.length; i++) {
									var area = {
										id : data[i].id,
										name : data[i].cname,
										level : data[i].level,
										parentId : data[i].upid
									};
									data[i] = area;
								}

								$('.bs-chinese-region').chineseRegion('source',
										data);//导入数据并实例化
							});
				})