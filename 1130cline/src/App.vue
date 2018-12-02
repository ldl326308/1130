<template>
  <div id="app">
    <Row>
			<Col span='1'>&emsp;</Col>
			<Col span='5'>
				<toform></toform>
			</Col>
			<Col span="1">&emsp;</Col>
			<Col span="15">
				<toshow></toshow>
			</Col>
		</Row>
    
  </div>
</template>

<script>
		import toform from './components/todo-form.vue'
		import toshow from './components/todo-show.vue'
		
export default {
		data() {
			return {

			};
		},
		components:{
			toform,
			toshow
		}
	}
		
</script>

<style>

</style>
