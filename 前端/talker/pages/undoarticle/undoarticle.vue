<template>
	<view>
		<editor @ready="ready($event)" id="editor"></editor>
		<view class="bar">
			<u-input type="text"  v-model="value" />
			<u-button @click="con()">aaa</u-button>
			<u-button @click="click()">发送</u-button>
			<u-button @click="get()">获取</u-button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				id: getApp().globalData.id,
				info: {},
				value: '',
			}
		},
		methods: {
			click(){
				uni.sendSocketMessage({
					data:JSON.stringify({Type:2,TypeVariety:0,From:this.id,content:JSON.stringify({OwnerId:this.id,Headline:'问题',Content:'问题描述',FId:-1})}),
					success(e){
						console.log(e)
					},
					fail(e){
						console.log(e)
					}
				})
			},
			get(){
				uni.sendSocketMessage({
					data:JSON.stringify({Type:2,TypeVariety:2,From:this.id,content:JSON.stringify({Type:2,AimId:1})}),
					complete(e){
						console.log(e)
					}
				})
			},
			con(){
				console.log(getContents(OBJECT))
			},
			ready(e){
				console.log(e)
				uni.createSelectorQuery().select('#editor').context(e=>console.log(e.context)).exec()
			}
		},
		onLoad() {
			// uni.onSocketMessage(e=>{
			// 	let t=JSON.parse(e.data)
			// 	console.log(t)
			// 	// this.info=JSON.parse(t.content)
			// })
		}
	}
</script>

<style>
	.bar{
		display: flex;
		position: absolute;
		width: 100%;
		bottom: 0;
	}
	u-input{
		font-size: 50rpx;
		border: 2rpx solid gray;
		border-radius: 15rpx;
		line-height: 100rpx;
		flex: 1;
	}
	u-button{
		line-height: 100rpx;
		width: 200rpx;
		background-color: white;
	}
</style>
