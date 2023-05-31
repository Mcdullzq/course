<template>
	<div id="showInfoContainer">
		<div >
			<img :src="tea.teaImage?tea.teaImage:img"/>
		</div>
		<div>
			<span>姓名:</span>{{tea.teaName}}
		</div>
		<div>
			<span>性别:</span>{{tea.teaSex==1?'男':'女'}}
		</div>
		<div>
			<span>邮箱:</span>{{tea.teaEmail}}
		</div>
	</div>
</template>

<script>
	export default{
		name:'ShowInfoView',
		data() {
			return {
				tea:{},
				img:require("@/assets/logo.png")
			}
		},
		created() {
			let str=sessionStorage.getItem("tea");
			this.tea=JSON.parse(str);
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