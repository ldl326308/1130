<template>

	<div class="demo-split">
		<Split mode="vertical">
			<div slot="top" class="demo-split-pane">
				<Menu mode='horizontal' active-name="1">
					<MenuItem  name="1">
					<Icon type="ios-outlet-outline" />
					<span @click="updClass($event)">未完成任务</span>
					</MenuItem>
					<MenuItem name="2">
					<Icon type="md-happy" />
					<span @click="updClass($event)">已完成任务</span>
					</MenuItem>
				</Menu>
			</div>
			<div slot="bottom" class="demo-split-pane">
				<br /><br /><br /><br />
				<div  v-bind:class="{ isActive: isActive }">
				<h3 v-for="item in dataOne" :key="item.id" style='margin-bottom: 10px;'>
					{{item.name}}&emsp;
					{{item.detail}}&emsp;
					{{item.createdAt}}&emsp;
					{{item.state}}&emsp;
					{{item.memo}}&emsp;
					<Button type="primary" @click="upd($event,item.id)">修改</Button>
				</h3>
				</div>
				<div v-bind:class="{ isActiveTwo: isActiveTwo }">
				<h3 v-for="item in dataTwo" :key="item.id" style='margin-bottom: 10px;' >
					{{item.name}}&emsp;
					{{item.detail}}&emsp;
					{{item.createdAt}}&emsp;
					{{item.finishedAt}}&emsp;
					{{item.state}}&emsp;
					{{item.memo}}&emsp;
				</h3>
				</div>
			</div>
		</Split>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				isActive: false,
				isActiveTwo: true,
				dataOne: [],
				dataTwo: []
			};
		},
		methods: {
			upd(event, id) {
				const se = this;
				console.log(id);
				fetch('http://localhost:8888/todo/'+id, {
					method: 'put',
				}).then(function(resp) {
					se.dataOne = [];
					se.dataTwo = [];
					se.show();
				});
			},
			updClass(event) {
				this.isActive = this.isActive == true ? false : true;
				this.isActiveTwo = this.isActiveTwo == true ? false : true;
			},
			show() {
				const se = this;
				fetch('http://localhost:8888/todo', {
					method: 'get',
				}).then(function(resp) {

					resp.json().then((data) => {
						for (let s of data) {
							if (s.state == '未完成') {
								se.dataOne.push({
									id:s.id,
									name:s.name,
									detail:s.detail,
									createdAt:new Date(s.createdAt),
									state:s.state,
									memo:s.memo
								});
							} else {
								se.dataTwo.push({
									id:s.id,
									name:s.name,
									detail:s.detail,
									createdAt:new Date(s.createdAt),
									finishedAt:new Date(s.finishedAt),
									state:s.state,
									memo:s.memo
								});
							}
						}
					});
				});
			}
		},
		created() {
			this.show();
		}
	}
</script>

<style>
	.isActive {
		display: none;
	}

	.isActiveTwo {
		display: none;
	}
</style>
