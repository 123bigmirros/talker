<template>
	<view>
		<u-field v-model="id" label="账号" placeholder="请输入账号"><u-button size="mini" slot="right" type="success" @click="click()">登录</u-button></u-field>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				id:0,
			}
		},
		methods: {
			click(){
				uni.sendSocketMessage({
					data:JSON.stringify({Type:1,TypeVariety:0,From:this.id}),
					complete(e){
						console.log(e)
					}
				})
			}
		},
		onLoad() {
			uni.$once('1',e=>{
				getApp().globalData.id=e.content.uId
				getApp().globalData.user=e.content
				uni.switchTab({url:'/pages/article/list'})
			})
		}
	}
</script>

<style>

</style>
