<template>
	<view>
		<view>
			<view>{{info.headline}}</view>
			<u-parse :html="info.content"></u-parse>
		</view>
		<u-gap></u-gap>
		<card :data="data"></card>
	</view>
</template>

<script>
import card from '../module/card.vue' 
export default {
	components: {
		card
	},
	data() {
		return {
			info: getApp().globalData.article,
			data: [],
			Begin: 0,
		}
	},
	methods: {
		req(){
			uni.sendSocketMessage({
				data:JSON.stringify({Type:3,TypeVariety:4,content:JSON.stringify({AimId:this.info.id,Begin:this.Begin,Len:5})}),
				complete(e){
					console.log(e)
				}
			})
		},
		res(e){
			switch(e.typeVariety){
				case 4:
					this.data=this.data.concat(Array.from(e.content))
					break
			}
		}
	},
	onLoad(e) {
		this.req()
		uni.$on('3',this.res)
	},
	onUnload() {
		uni.$off('3',this.res)
	}
}
</script>

<style>

</style>
