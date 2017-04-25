# bootstrap-chinese-region

基于bootstrap的中国地区（行政区）选择器

## 例子

[Example](http://bootstrap-chinese-region.coding.io/)

html结构
	
	<head>
		<link rel="stylesheet" href="lib/bootstrap/bootstrap.css">
		<link rel="stylesheet" href="lib/bootstrap-chinese-region/bootstrap-chinese-region.css">
	<head/>

	<div class="form-group">
		<label for="address">地区</label>
		<div class="bs-chinese-region flat dropdown" data-submit-type="id" data-min-level="1" data-max-level="3">
			<input type="text" class="form-control" name="address" id="address" placeholder="选择你的地区" data-toggle="dropdown" readonly="" value="440103">
			<div class="dropdown-menu" role="menu" aria-labelledby="dLabel">
				<div>
					<ul class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active"><a href="#province" data-next="city" role="tab" data-toggle="tab">省份</a></li>
						<li role="presentation"><a href="#city" data-next="district" role="tab" data-toggle="tab">城市</a></li>
						<li role="presentation"><a href="#district" data-next="street" role="tab" data-toggle="tab">县区</a></li>
					</ul>
					<div class="tab-content">
						<div role="tabpanel" class="tab-pane active" id="province">--</div>
						<div role="tabpanel" class="tab-pane" id="city">--</div>
						<div role="tabpanel" class="tab-pane" id="district">--</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="lib/jquery/jquery.js"></script>
	<script type="text/javascript" src="lib/bootstrap/bootstrap.js"></script>
	<script type="text/javascript" src="lib/bootstrap-chinese-region/bootstrap-chinese-region.js"></script>

js代码

	<script type="text/javascript">
		$.getJSON('lib/bootstrap-chinese-region/sql_areas.json',function(data){
			
			/**重定义数据结构**/
			/**
			 * id 键,name 名字,level 层级,parentId 父级
			 */
			for (var i = 0; i < data.length; i++) {
				var area = {id:data[i].id,name:data[i].cname,level:data[i].level,parentId:data[i].upid};
				data[i] = area;
			}

			$('.bs-chinese-region').chineseRegion('source',data);//导入数据并实例化
		});
	</script>

##方法

显示（或隐藏）下拉框	
`$('.bs-chinese-region').chineseRegion('toggle')`

导入数据	
`$('.bs-chinese-region').chineseRegion('source',data)`

取得数据	
`$('.bs-chinese-region').chineseRegion('source')`

设置地区有效层级（显示与获得的地区层级范围）	
`$('.bs-chinese-region').chineseRegion('level',min,max)`

重绘地区选择器	
`$('.bs-chinese-region').chineseRegion('render',id)`

> 传入id 则自动选择层级范围内的id地区及父级地区
> 没传入id 则重绘地区层级范围最小地区

##事件
当选择了地区后促发`changed.bs.chinese-region`事件

	$('.bs-chinese-region').chineseRegion('source',data).on('changed.bs.chinese-region',function(e,areas){
		//areas是已选择的地区数据，按先选择的在最前的方式排序。
	});


当选择了最后的层级地区后促发`completed.bs.chinese-region`事件

	$('.bs-chinese-region').chineseRegion('source',data).on('completed.bs.chinese-region',function(e,areas){
		//areas是已选择的地区数据，按先选择的在最前的方式排序。
	});

##其他
在`bs-chinese-region`元素中设置以下`data-`属性会自动加载内容

	data-submit-type="id" //设置id，提交表单时会自动把input的值改为层级最下层的地区id
	data-min-level="1" //设定最上层
	data-max-level="3" //设定最下层
	
### dropload git 地址
	https://github.com/ximan/dropload
	
	依赖 (dependence)

Zepto 或者 jQuery 1.7以上版本，推荐jQuery 2.x版本（二者不要同时引用） 
Zepto or jQuery 1.7+，recommend to use jQuery 2.x（not use them at the same time）

使用方法 (usage)

引用css和js 
(basic)

<link rel="stylesheet" href="../dist/dropload.css">
<script src="../dist/dropload.min.js"></script>
$('.element').dropload({
    scrollArea : window,
    loadDownFn : function(me){
        $.ajax({
            type: 'GET',
            url: 'json/more.json',
            dataType: 'json',
            success: function(data){
                alert(data);
                // 每次数据加载完，必须重置
                me.resetload();
            },
            error: function(xhr, type){
                alert('Ajax error!');
                // 即使加载出错，也得重置
                me.resetload();
            }
        });
    }
});
（注明：所有示例里ajax和setTimeout都是为了模拟加载效果而写的，与本插件无直接关系。ajax建议自己写，无特殊情况不必copy我的ajax写法，因为写得太烂。如需下载本地运行，请在本机装服务器环境，否则ajax会报错。）

参数列表 (options)

参数	说明	默认值	可填值
scrollArea	滑动区域	绑定元素自身	window
domUp	上方DOM	{
domClass : 'dropload-up',
domRefresh : '<div class="dropload-refresh">↓下拉刷新</div>',
domUpdate : '<div class="dropload-update">↑释放更新</div>',
domLoad : '<div class="dropload-load">○加载中...</div>'
}	数组
domDown	下方DOM	{
domClass : 'dropload-down',
domRefresh : '<div class="dropload-refresh">↑上拉加载更多</div>',
domLoad : '<div class="dropload-load">○加载中...</div>',
domNoData : '<div class="dropload-noData">暂无数据</div>'
}	数组
autoLoad	自动加载	true	true和false
distance	拉动距离	50	数字
threshold	提前加载距离	加载区高度2/3	正整数
loadUpFn	上方function	空	function(me){
//你的代码
me.resetload();
}
loadDownFn	下方function	空	function(me){
//你的代码
me.resetload();
}
API

暴露一些功能，可以让dropload更灵活的使用

lock() 锁定dropload

参数	说明
lock()	智能锁定，锁定上一次加载的方向
lock('up')	锁定上方
lock('down')	锁定下方
unlock() 解锁dropload

noData() 无数据

参数	说明
noData()	无数据
noData(true)	无数据
noData(false)	有数据
resetload() 重置。每次数据加载完，必须重置

已知问题

由于部分Android中UC和QQ浏览器头部有地址栏，并且一开始滑动页面隐藏地址栏时，无法触发scroll和resize，所以会导致部分情况无法使用。解决方案1：增加distance距离，例如DEMO2中distance:50；解决方案2：加meta使之全屏显示
<meta name="full-screen" content="yes">
<meta name="x5-fullscreen" content="true">