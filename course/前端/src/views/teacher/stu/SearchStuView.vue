<template>
	<div id="searchStuContainer">
		<div id="searchContent">
			<el-form :inline="true">
				<el-form-item label="学生姓名:">
					<el-input v-model="stu.stuName"></el-input>
				</el-form-item>
				<el-form-item label="学生性别:">
					<el-select v-model="stu.stuSex">
						<el-option label="所有" value="0"></el-option>
						<el-option label="男" value="1"></el-option>
						<el-option label="女" value="2"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item>
					<el-button @click="doSearch">查询</el-button>
				</el-form-item>
			</el-form>
		</div>
		<div id="searchResult">
			<el-table :data="stus" border>
				<el-table-column label="序号" prop="stuId"></el-table-column>
				<el-table-column label="姓名" prop="stuName"></el-table-column>
				<el-table-column label="性别">
					<template #default="scope">
						{{scope.row.stuSex==1?'男':'女'}}
					</template>
				</el-table-column>
				<el-table-column label="邮箱" prop="stuEmail"></el-table-column>
				<el-table-column label="状态">
					<template #default="scope">
						{{scope.row.stuStatus==1?'在读':'离司'}}
					</template>
				</el-table-column>
				<el-table-column label="操作">
					<template #default="scope">
						<router-link to="#" @click="showEditDialog(scope.row)">编辑</router-link>
						<router-link to="#" @click="showDeleteDialog(scope.row)">删除</router-link>
					</template>
				</el-table-column>
			</el-table>
		</div>
	</div>
	<!-- 删除对话框 -->
	  <el-dialog
	    v-model="deleteDialogVisible"
	    title="提示"
	    width="30%"
	    align-center
	  >
	    <span>您确定要删除【{{param.stuName}}】吗?</span>
	    <template #footer>
	      <span class="dialog-footer">
	        <el-button @click="deleteDialogVisible = false">取消</el-button>
	        <el-button type="primary" @click="doDelete">
	          确定
	        </el-button>
	      </span>
	    </template>
	  </el-dialog>
	  <!-- 修改对话框 -->
	    <el-dialog
	      v-model="editDialogVisible"
	      title="编辑"
	      width="30%"
	      align-center
	    >
	      <div id="editStuContent">
			  <el-form label-width="120px">
				  <el-form-item label="学生姓名:">
					  <el-input v-model="param.stuName"></el-input>
				  </el-form-item>
				  <el-form-item label="学生性别:">
					  <el-select v-model="param.stuSex">
						  <el-option label="男" :value="1"></el-option>
						  <el-option label="女" :value="2"></el-option>
					  </el-select>
				  </el-form-item>
				  <el-form-item label="学生邮箱:">
					  <el-input v-model="param.stuEmail"></el-input>
				  </el-form-item>
				  <el-form-item label="学生状态:">
					  <el-select v-model="param.stuStatus">
						  <el-option label="在读" :value="1"></el-option>
						  <el-option label="离司" :value="2"></el-option>
					  </el-select>
				  </el-form-item>
			  </el-form>
		  </div>
	      <template #footer>
	        <span class="dialog-footer">
	          <el-button @click="editDialogVisible = false">取消</el-button>
	          <el-button type="primary" @click="doEdit">
	            确定
	          </el-button>
	        </span>
	      </template>
	    </el-dialog>
</template>

<script>
	export default{
		name:'SearchStuView',
		data() {
			return{
				stu:{
					stuName:'',
					stuSex:'0'
				},
				stus:[],
				deleteDialogVisible:false,
				param:{},
				editDialogVisible:false,
			}
		},
		
		methods:{
			doSearch(){
				this.$axios.post("StuInfoController/findByParam",this.stu)
				.then(rst=>{
					this.stus=rst.data.data;
				}).catch(err=>{
					console.log(err)
				})
			},
			showDeleteDialog(row){
				this.param=row;
				this.deleteDialogVisible=true;
			},
			doDelete(){
				this.$axios.post("StuInfoController/delete",this.param)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("操作成功!")
						this.doSearch()
					}else{
						this.$message("操作失败!")
					}
					this.deleteDialogVisible=false;
				})
			},
			showEditDialog(row){
				this.param=row;
				this.editDialogVisible=true;
			},
			doEdit(){
				this.$axios.post("StuInfoController/update",this.param)
				.then(rst=>{
					if(rst.data.code==200){
						this.$message("操作成功!")
						this.doSearch()
						this.editDialogVisible=false;
					}else{
						this.$message("操作失败!")
					}
				})
			}
		}
	}
</script>

<style scoped>
	#searchContent,#searchResult{
		margin: 20px;
	}
	#editStuContent{
		margin-right: 50px;
	}
	.el-select{
		width: 100%;
	}
</style>