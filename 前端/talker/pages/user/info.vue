<template>
	<view>
		<view class="nav">
			<navigator url="/pages/user/message"><u-icon name="chat" size="64"></u-icon></navigator>
		</view>
		<view style="text-align:center;font-size:64rpx;">{{info.name}}</view>
		<u-grid :col="2">
			<u-grid-item>
				<view>0</view>
				<view>收藏</view>
			</u-grid-item>
			<u-grid-item>
				<view>0</view>
				<view>浏览</view>
			</u-grid-item>
		</u-grid>
		<view>
			<u-cell-item title="微信">{{info.weChat}}</u-cell-item>
			<u-cell-item title="QQ">{{info.qQ}}</u-cell-item>
			<u-cell-item title="电话">{{info.phone}}</u-cell-item>
			<u-cell-item title="个人文章" @click="click('/pages/user/article')"></u-cell-item>
		</view>
		<u-tabbar :list="tabbar" mid-button></u-tabbar>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				id: getApp().globalData.id,
				info: getApp().globalData.user,
				tabbar: getApp().globalData.tabbar
			}
		},
		methods: {
			click(e){
				uni.navigateTo({url:e})
			}
		},
		onLoad() {
			uni.$once('1',e=>{
				switch(e.typeVariety){
					case 1:
						this.info=e.content
						break
				}
			})
		}
	}
</script>

<style lang="scss">
.nav{
	display: flex;
	justify-content: flex-end;
}
uni-button{
	width: 75%;
}
.btn{
	text-align: center;
	font-size: 2em;
	color: $uni-border-radius-base;
	width: 80%;
	margin: 0 auto;
	border: 1rpx solid $uni-border-color;
	border-radius: .5em;
}
</style>
