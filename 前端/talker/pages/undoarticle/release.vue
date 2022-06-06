<template>
	<view>
		<u-field v-model="info.Title" label="标题"></u-field>
		<editor></editor>
		<u-button type="primary" @click="click()">发布</u-button>
		<u-tabbar :list="tabbar" :active-color="$u.color['primary']" mid-button></u-tabbar>
	</view>
</template>

<script>
	import editor from '../editor/editor'
	export default {
		data() {
			return {
				info: getApp().globalData.undoarticle,
				tabbar: getApp().globalData.tabbar
			}
		},
		methods: {
			click(){
				
			}
		},
		components: {
			editor
		}
	}
</script>

<style>

</style>
