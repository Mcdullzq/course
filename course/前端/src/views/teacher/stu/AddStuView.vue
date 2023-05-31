<template>
	<div id="addStuContainer">
		<el-form label-width="120px" size="large">
			<el-form-item label="学生姓名:">
				<el-input v-model="stu.stuName"></el-input>
			</el-form-item>
			<el-form-item label="学生性别:">
				<el-select v-model="stu.stuSex">
					<el-option label="男" value="1"></el-option>
					<el-option label="女" value="2"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="注册邮箱:">
				<el-input v-model="stu.stuEmail"></el-input>
			</el-form-item>
			<el-form-item>
				<el-button @click="doSave">添加</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	export default{
		name:'AddStuView',
		data() {
			return{
				stu:{
					stuName:'',
					stuSex:'1',
					stuEmail:''
				}
			}
		},
		methods:{
			doSave(){
				this.$axios.post("StuInfoController/save",this.stu)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("添加成功!")
						this.stu={
							stuName:'',
							stuSex:'1',
							stuEmail:''
						};
					}else{
						this.$message("添加失败!")
					}
				})
			}
		}
	}
</script>

<style scoped>
	#addStuContainer{
		width: 450px;
		margin-top: 20px;
	}
	.el-select{
		width: 100%;
	}
</style>