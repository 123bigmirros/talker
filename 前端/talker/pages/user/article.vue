<template>
	<view>
		<view class="wrap">
			<view class="u-tabs-box">
				<u-tabs-swiper ref="tabs" :list="list" :current="current" @change="change" :is-scroll="false" swiperWidth="750"></u-tabs-swiper>
			</view>
			<swiper class="swiper-box" :current="swiperCurrent" @transition="transition" @animationfinish="animationfinish">
				<swiper-item class="swiper-item"><card :data="article"></card></swiper-item>
				<swiper-item class="swiper-item"><card :data="doarticle"></card></swiper-item>
				<swiper-item class="swiper-item"><card :data="undoarticle"></card></swiper-item>
			</swiper>
		</view>
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
			id: getApp().globalData.id,
			list: [
				{
					name: '已通过'
				},
				{
					name: '未通过'
				},
				{
					name: '未审核'
				}
			],
			current: 0,
			swiperCurrent: 0,
			dx: 0,
			article: [],
			undoarticle: [],
			doarticle: []
		};
	},
	methods: {
		change(index) {
			this.swiperCurrent = index
		},
		transition({ detail: { dx } }) {
			this.$refs.tabs.setDx(dx)
		},
		animationfinish({ detail: { current } }) {
			this.$refs.tabs.setFinishCurrent(current)
			this.swiperCurrent = current
			this.current = current
		}
	},
	onLoad() {
		uni.sendSocketMessage({
			data:JSON.stringify({Type:2,TypeVariety:2,content:JSON.stringify({AimId:this.id,Begin:0,Len:10})})
		})
		uni.sendSocketMessage({
			data:JSON.stringify({Type:3,TypeVariety:0,content:JSON.stringify({AimId:this.id,Begin:0,Len:10})})
		})
		uni.$once('2',e=>{
			console.log(e)
			switch(e.typeVariety){
				case 2:
					this.undoarticle=Array.from(e.content).filter(x=>!Boolean(x.Status))
					this.doarticle=Array.from(e.content).filter(x=>Boolean(x.Status))
					break
			}
		})
		uni.$once('3',e=>{
			console.log(e)
			switch(e.typeVariety){
				case 0:
					this.article=Array.from(e.content)
					break
			}
		})
	}
}
</script>

<style lang="scss">
.centre {
	text-align: center;
	margin: 200rpx auto;
	font-size: 32rpx;
	image {
		width: 164rpx;
		height: 164rpx;
		border-radius: 50%;
		margin-bottom: 20rpx;
	}
	.tips {
		font-size: 24rpx;
		color: #999999;
		margin-top: 20rpx;
	}
	.btn {
		margin: 80rpx auto;
		width: 200rpx;
		border-radius: 32rpx;
		line-height: 64rpx;
		color: #ffffff;
		font-size: 26rpx;
		background: linear-gradient(270deg, rgba(249, 116, 90, 1) 0%, rgba(255, 158, 1, 1) 100%);
	}
}
.wrap {
	display: flex;
	flex-direction: column;
	height: calc(100vh - var(--window-top) - 100rpx);
	width: 100%;
}
.swiper-box {
	flex: 1;
}
scroll-view {
	width: 100%;
	height: 100%;
}
</style>
