<template>
	<div id="showInfoContainer">
		<div >
			<img :src="stu.stuImage?stu.stuImage:img"/>
		</div>
		<div>
			<span>姓名:</span>{{stu.stuName}}
		</div>
		<div>
			<span>性别:</span>{{stu.stuSex==1?'男':'女'}}
		</div>
		<div>
			<span>邮箱:</span>{{stu.stuEmail}}
		</div>
	</div>
</template>

<script>
	export default{
		name:'ShowInfoView',
		data() {
			return {
				stu:{},
				img:require("@/assets/logo.png")
			}
		},
		created() {
			let str=sessionStorage.getItem("stu");
			this.stu=JSON.parse(str);
		}
	}
</script>

<style scoped>
	#showInfoContainer div{
		width: 300px;
		height: 50px;
		display: flex;
		justify-content: left;
		align-items: center;
		font-size: 20px;
		margin-left: 50px;
	}
	#showInfoContainer div:first-child{
		height: 200px;
		justify-content: center;
	}
	#showInfoContainer div:first-child img{
		width: 100px;
		height: 100px;
		border-radius: 50%;
		border:1px solid white;
	}
</style>