<script>
	export default {
		mpType: 'app',
		globalData: {
			id: 0,
			user: {},
			article: {},
			articleList: [],
			historyMsg: [],
			undoarticle: {Headline:'',Content:'',OwnerId:0},
			tabbar: [
				{
					iconPath: "home",
					selectedIconPath: "home-fill",
					text: '首页',
					pagePath: '/pages/article/list',
				},
				{
					iconPath: "plus-circle",
					selectedIconPath: "plus-circle-fill",
					text: '发布',
					midButton: true,
					pagePath: '/pages/editor/editor',
				},
				{
					iconPath: "account",
					selectedIconPath: "account-fill",
					text: '我的',
					pagePath: '/pages/user/info',
				}
			]
		},
		onLaunch() {
			uni.connectSocket({url:'ws://localhost:8080'})
			uni.onSocketMessage(({data})=>{
				data=JSON.parse(data)
				console.log(data)
				if(Boolean(data.content))
					data.content=JSON.parse(data.content)
				if(Boolean(data.type)){
					switch(data.type){
						case 1:
							this.globalData.user=data.content
							break
						case 3:
							this.globalData.articleList=Array.from(data.content)
							break
					}
					uni.$emit(String(data.type),data)
				}
			})
			uni.onSocketError(e=>{
				console.log(e)
			})
		},
		
		// onShow: function() {
		// 	console.log('App Show')
		// },
		// onHide: function() {
		// 	console.log('App Hide')
		// }
	}
</script>

<style lang="scss">
	@import "uview-ui/index.scss";
</style>
