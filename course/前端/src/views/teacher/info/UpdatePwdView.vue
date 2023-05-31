<template>
	<div id="updatePwdContainer">
		<el-form label-width="120px" size="large">
			<el-form-item label="原始密码:">
				<el-input type="password" v-model="tea.teaOldPwd"></el-input>
			</el-form-item>
			<el-form-item label="新密码:">
				<el-input type="password" v-model="tea.teaPwd"></el-input>
			</el-form-item>
			<el-form-item label="确认密码:">
				<el-input type="password" v-model="tea.rePwd"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button @click="doSave">确定</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default{
		name:'UpdatePwdView',
		data() {
			return{
				tea:{
					teaPwd:'',
					rePwd:'',
					teaOldPwd:'',
					teaId:''
				}
			}
		},
		methods:{
			doSave(){
				let str=sessionStorage.getItem("tea");
				this.tea.teaId=JSON.parse(str).teaId;
				this.$axios.post("TeaInfoController/updatePwd",this.tea)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("密码修改成功!下次请使用新密码登录!");
            this.$router.push("/login");
					}else{
						this.$message("密码修改失败!")
					}
				})
			}
		}
	}
</script>

<style scoped>
	#updatePwdContainer{
		width: 350px;
		margin-top: 20px;
	}
</style>