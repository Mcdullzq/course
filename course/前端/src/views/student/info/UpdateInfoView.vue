<template>
	<div id="updateInfoContainer">
		<el-form label-width="120px" size="large">
			<el-form-item label="姓名:">
				<el-input v-model="stu.stuName"></el-input>
			</el-form-item>
			<el-form-item label="性别:">
				<el-select v-model="stu.stuSex">
					<el-option label="男" :value="1"></el-option>
					<el-option label="女" :value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="邮箱:">
				<el-input v-model="stu.stuEmail"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button @click="doSave">修改</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default{
		name:'UpdateInfoView',
		data() {
			return{
				stu:{}
			}
		},
		created() {
			let str=sessionStorage.getItem("stu");
			this.stu=JSON.parse(str);
		},
		methods:{
			doSave(){
				this.$axios.post("StuInfoController/update",this.stu)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("操作成功!");
					}else{
						this.$message("操作失败!")
					}
				})
			}
		}
	}
</script>

<style scoped>
	#updateInfoContainer{
		width: 350px;
		margin-top: 20px;
	}
	.el-select{
		width: 100%;
	}
</style>