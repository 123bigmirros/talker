<template>
	<scroll-view :scroll-y="true">
		<u-card v-for="(item,index) in data" :key="index" @click="click(index)">
			<view slot="head">{{item.headline}}</view>
			<u-parse slot="body" :html="item.content"></u-parse>
			<view slot="foot"><u-icon name="chat" size="34" label="30评论"></u-icon></view>
		</u-card>
	</scroll-view>
</template>

<script>
export default {
	props: ['data'],
	data() {
		return {
		}
	},
	methods: {
		click(e){
			const t=this.data[e]
			getApp().globalData.article=t
			if(Number(t.type)<1)uni.navigateTo({url:'/pages/article/info'})
			else uni.navigateTo({url:'/pages/article/question'})
		}
	}
}
</script>

<style lang="scss" scoped>
</style>