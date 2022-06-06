<template>
	<view>
		<u-swipe-action :show="item.show" :index="index" 
			v-for="(item, index) in list" :key="index" 
			@click="click" @open="open"
			:options="options"
		>
			<navigator class="item u-border-bottom" :url="'/pages/user/chat?id='+item.id">
				<view class="title-wrap">
					<text class="title u-line-2">{{ item.id }}</text>
					<text class="title u-line-2">{{ item.title }}</text>
				</view>
			</navigator>
		</u-swipe-action>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				list: [
					{
						id: 3,
						title: '长安回望绣成堆，山顶千门次第开，一骑红尘妃子笑，无人知是荔枝来',
						show: false
					},
					{
						id: 4,
						title: '新丰绿树起黄埃，数骑渔阳探使回，霓裳一曲千峰上，舞破中原始下来',
						show: false
					}
				],
				disabled: false,
				btnWidth: 180,
				show: false,
				options: [
					{
						text: '删除',
						style: {
							backgroundColor: '#dd524d'
						}
					}
				]
			};
		},
		methods: {
			click(index) {
				this.list.splice(index, 1);
				this.$u.toast(`删除了第${index}个cell`);
			},
			chat(index) {
				console.log(index)
			},
			open(index) {
				this.list.map((val, idx) => this.list[idx].show = false)
				this.list[index].show = true;
			}
		}
	};
</script>

<style lang="scss" scoped>
	.item {
		display: flex;
		padding: 20rpx;
	}
	
	image {
		width: 120rpx;
		flex: 0 0 120rpx;
		height: 120rpx;
		margin-right: 20rpx;
		border-radius: 12rpx;
	}
	
	.title {
		text-align: left;
		font-size: 28rpx;
		color: $u-content-color;
		margin-top: 20rpx;
	}
</style>