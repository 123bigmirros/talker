<template>
	<swiper vertical>
		<swiper-item v-for="(item,index) in data" :key="index">
			<u-card :index="index" @click="$emit('click',index)">
				<view slot="head">{{item.headline}}</view>
				<u-parse slot="body" :html="item.content"></u-parse>
				<view slot="foot"><u-icon name="thumb-up" size="34" :label="item.agree"></u-icon></view>
			</u-card>
		</swiper-item>
	</swiper>
</template>

<script>
export default {
	props: ['data','click']
}
</script>

<style lang="scss" scoped>
	swiper{
		height: calc(100vh - var(--window-top) - 148rpx);
	}
</style>
