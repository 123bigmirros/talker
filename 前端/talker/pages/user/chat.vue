<template>
	<cola-u-chat
		:userId="userId"
		IDType="msgId"
		:dataKeys="dataKeys"
		:messageData="msgData"
		:updateMsg="updateMsg"
		:historyMsg="historyMsg"
		@sendMsg="send"
	/>
</template>

<script>
	import colaUChat from '../module/cola-u-chat'
	export default {
		components: {
			colaUChat
		},
		data(){
			return{
				userId: getApp().globalData.id,
				To: 0,
				msgId: 0,
				avator: '/static/user.svg',
				dataKeys: {
					msgId:'Id',
					userId:'From',
					message:'Content',
					avator:'To'
				},
				msgData: [],
				historyMsg: getApp().globalData.historyMsg,
				updateMsg: {}
			}
		},
		methods: {
			send(e) {
				(t=>{
					delete t.Id
					t.To=this.To
					uni.sendSocketMessage({
						data:JSON.stringify({Type:7,TypeVariety:0,content:JSON.stringify(t)})
				})})(this.updateMsg={
					Id: ++this.msgId,
					From: this.userId,
					Content: e,
					To: this.avator,
				})
			},
			res(e){
				switch(e.typeVariety){
					case 0:
						this.updateMsg=(x=>{
							x.Id=++this.msgId
							x.To=this.avator
							return x
						})(e.content)
						break
				}
				console.log(e)
			},
		},
		onLoad(e) {
			if(Object.keys(e).length)
				this.To=e.id
			uni.$on('7',this.res)
		},
		onUnload() {
			uni.$off('7',this.res)
		}
	}
</script>

<style lang="scss">
	.self-body,.msgBody-rg {
		font-size: larger;
	}
</style>
