<template>
	<div id='main'>
		<h2 style="text-align: center;">添加任务</h2>
		<br />
		<p>姓名<span style='color:red'>*</span>：
			<Input v-model="name" placeholder="请输入姓名" name='name' clearable style="width: 200px" />
		</p>
		<br />
		<p>任务<span style='color:red'>*</span>：
			<textarea cols="30" name="detail" v-model="detail"></textarea>
		</p>
		<br />
		<p>备忘录：<textarea cols="30" name="memo" v-model="memo"></textarea></p>
		<br />
		<p>
			<Button @click='addTodo()' type="primary">添加任务</Button>&emsp;
			<Button @click='reset()' type="info">重置</Button>
		</p>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				name: '',
				detail: '',
				memo: ''
			}
		},
		methods: {
			reset() {
				this.name = '';
				this.detail = '';
				this.memo = '';
			},
			addTodo() {
				var se = this;

				if (this.name == '' || this.detail == '' || this.date == '') {
					this.$Modal.error({
						title: '提示框',
						content: '必填项不能为空'
					});
					return false;
				}

				//http://localhost:8888/todo

				var subData = {
					name: this.name,
					detail: this.detail,
					memo: this.memo
				};


				fetch('http://localhost:8888/todo', {
					method: 'post',
					headers: {
						"Content-Type": "application/json",
						"Accept": "application/json"
					},
					body: JSON.stringify(subData)
				}).then(function(resp) {
					resp.json().then((data) => {
						window.location.href = 'http://localhost:8080/';
					});
					se.reset();
				});


			}
		}
	}
</script>

<style>
	#main p {
		text-align: right;
	}
</style>
