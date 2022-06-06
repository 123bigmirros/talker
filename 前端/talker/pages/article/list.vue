<template>
	<view>
		<view class="nav">
			<u-search placeholder="搜索" v-model="keyword" :show-action="false"></u-search>
			<navigator url="/pages/user/message"><u-icon name="chat" size="64"></u-icon></navigator>
		</view>
<!-- 		<swiper vertical>
			<swiper-item v-for="(item,index) in Data" :key="index">
				<u-card :index="index" @click="click">
					<view slot="head">{{item.headline}}</view>
					<u-parse slot="body" :html="item.content"></u-parse>
					<view slot="foot"><u-icon name="thumb-up" size="34" :label="item.agree"></u-icon></view>
				</u-card>
			</swiper-item>
		</swiper> -->
		<list :data="Data" @click="click"></list>
		<u-tabbar :list="tabbar" mid-button></u-tabbar>
	</view>
</template>

<script>
	import list from '../module/list'
	export default {
		components: {
			list
		},
		data() {
			return {
				Data: getApp().globalData.articleList,
				keyword: '',
				Begin: 0,
				tabbar: getApp().globalData.tabbar
			}
		},
		methods: {
			req(){
				uni.sendSocketMessage({
					data:JSON.stringify({Type:3,TypeVariety:1,content:JSON.stringify({Type:1,Begin:this.Begin,Len:5})}),
					complete(e){
						console.log(e)
					}
				})
			},
			res(e){
				switch(e.typeVariety){
					case 1:
						this.Data=this.Data.concat(Array.from(e.content))
						break
				}
						console.log(this.Data)
			},
			click(e){
				const t=this.Data[e]
				getApp().globalData.article=t
				if(Number(t.type)<1)uni.navigateTo({url:'/pages/article/info'})
				else uni.navigateTo({url:'/pages/article/question'})
			}
		},
		onLoad() {
			this.req()
			uni.$on('3',this.res)
		},
		onUnload() {
			uni.$off('3',this.res)
		}
	}
</script>

<style lang="scss">
	.nav{
		display: flex;
		justify-content: space-between;
	}
</style>
