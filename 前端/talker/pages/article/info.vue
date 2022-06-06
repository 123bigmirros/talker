<template>
	<view>
		<scroll-view>
			<text>{{info.headline}}</text>
			<u-parse :html="info.content"></u-parse>
		</scroll-view>
		<view class="bottom">
			<view v-for="(item,index) in list" :key="index">
				<u-icon v-for="(e,i) in item" :name="name[index<<1|i]+(e?'-fill':'')" @click="click(index<<1|i)" :key="i"></u-icon>
			</view>
		</view>
		<u-popup v-model="list[1][1]" mode="bottom">
			<view>
				<view class="comment" v-for="(res, index) in commentList" :key="res.id">
					<view class="right">
						<view class="top">
							<view class="name">{{ res.ownername }}</view>
							<view class="like" :class="{ highlight: res.isLike }">
								<view class="num">{{ res.agree }}</view>
								<u-icon v-if="!res.isLike" name="thumb-up" :size="30" color="#9a9a9a" @click="getLike(index)"></u-icon>
								<u-icon v-if="res.isLike" name="thumb-up-fill" :size="30" @click="getLike(index)"></u-icon>
							</view>
						</view>
						<view class="content">{{ res.content }}</view>
						<view class="reply-box">
							<view class="item" v-for="(item, index) in res.replyList" :key="item.index">
								<view class="username">{{ item.ownername }}</view>
								<view class="text">{{ item.content }}</view>
							</view>
						</view>
						<view class="bottom">
							{{ res.time }}
							<view class="reply">回复</view>
						</view>
					</view>
				</view>
			</view>
			<u-field v-model="comment" placeholder="请输入评论"><u-button size="mini" slot="right" type="primary" @click="submit()">评论</u-button></u-field>
		</u-popup>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				id: getApp().globalData.id,
				info: getApp().globalData.article,
				comment: '',
				commentList: [],
				list: [[false,false],[false,false]],
				name: ['thumb-up','thumb-down','star','chat']
			}
		},
		methods: {
			click(e){
				if(e<3){
					uni.sendSocketMessage({
						data:JSON.stringify({Type:6,TypeVariety:e<<1|Number(this.list[e>>1][e&1]),content:JSON.stringify({UserId:this.id,AimId:this.info.id,Type:0})})
					})
				}
				this.list[e>>1][e&1]=!this.list[e>>1][e&1]
				this.list=Array.from(this.list)
			},
			submit(){
				uni.sendSocketMessage({
					data:JSON.stringify({Type:5,TypeVariety:0,content:JSON.stringify({OwnerId:this.id,ArticleId:this.info.id,Content:this.comment})})
				})
			},
			res(e){
				switch(e.typeVariety){
					case 1:
						this.commentList=this.commentList.concat(Array.from(e.content))
						break
				}
			},
			getLike(index) {
				this.commentList[index].isLike=!this.commentList[index].isLike
				if (this.commentList[index].isLike)this.commentList[index].likeNum++
				else this.commentList[index].likeNum--
			}
		},
		onLoad() {
			uni.sendSocketMessage({
				data:JSON.stringify({Type:5,TypeVariety:1,content:JSON.stringify({AimId:this.info.id,Begin:0,Len:5})}),
				complete(e){
					console.log(e)
				}
			})
			uni.$on('5',this.res)
		},
		onUnload() {
			uni.$off('5',this.res)
		}
	}
</script>

<style lang="scss">
	.bottom{
		position: absolute;
		display: flex;
		width: 100%;
		bottom: 0;
		justify-content: space-between;
		*{
			font-size: 50rpx;
		}
	}
	.comment {
		display: flex;
		padding: 30rpx;
		.right {
			flex: 1;
			padding-left: 20rpx;
			font-size: 30rpx;
			.top {
				display: flex;
				justify-content: space-between;
				align-items: center;
				margin-bottom: 10rpx;
				.name {
					color: #5677fc;
				}
				.like {
					display: flex;
					align-items: center;
					color: #9a9a9a;
					font-size: 26rpx;
					.num {
						margin-right: 4rpx;
						color: #9a9a9a;
					}
				}
				.highlight {
					color: #5677fc;
					.num {
						color: #5677fc;
					}
				}
			}
			.content {
				margin-bottom: 10rpx;
			}
			.reply-box {
				background-color: rgb(242, 242, 242);
				border-radius: 12rpx;
				.item {
					padding: 20rpx;
					border-bottom: solid 2rpx $u-border-color;
					.username {
						font-size: 24rpx;
						color: #999999;
					}
				}
			}
			.bottom {
				margin-top: 20rpx;
				display: flex;
				font-size: 24rpx;
				color: #9a9a9a;
				.reply {
					color: #5677fc;
					margin-left: 10rpx;
				}
			}
		}
	}
	
</style>
