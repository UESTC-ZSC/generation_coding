### 1. 介绍
基于代码生成器的`web低代码`开发平台，面向的用户是Java后端程序员。采用前后端分离架构：SpringBoot 2.x，Element/Ant Design & Vue3.0 & TypeScript，SpringSecurity，Jpa & QueryDsl。Online 在线数据库建模，在线编辑基础 API 接口，在线配置页面组件，一键生成代码同步到远程仓库。帮助程序员快速搭建项目，让开发更多关注业务。并且该项目提供丰富的扩展接口，在代码生成的基础上更容易发开。
### 2. 项目架构
#### 代码生成平台架构：
技术选型：

- 后端：SpringBoot，Spring Security，Mybatis/Mybatis-plus/JPA（待定），Swagger-UI，Redis，Hutool，JWT
- 前端：Vite，Vue3.2，TypeScript，Axios，Element/Ant Design，Vxe-table

功能

1. 基础权限控制
2. 后台项目管理
3. git 仓库管理
   1. 创建 repository 或者 remote github/gitlab
   2. 将生成的代码 push 到远程仓库
4. 数据建模
   1. 基础实体
   2. 实体
   3. 视图实体
5. 接口配置
   1. 关联实体
   2. 自动生成标准 API 方法
6. 表单配置
   1. 查询参数配置
   2. 表格项配置
   3. 关联实体类和API接口

项目代码生成

   4. 根据配置实体信息生成实体类
   5. 根据API管理生成对应接口
   6. 页面代码生成
#### 代码生成基础模版：
技术选型：

- 后端：SpringBoot，Spring Security，Mybatis/Mybatis-plus/JPA（待定），Swagger-UI，Redis，Hutool，JWT
- 前端：Vite，Vue3.2，TypeScript，Axios，Element/Ant Design，Vxe-table

功能：

1. 基础的权限控制
### 3. 核心功能
#### 后端代码生成

- 实体类生成
- 接口生成
#### 前端代码生成

- 动态路由
- 接口生成
- 页面组件生成
### 4. 后端架构

-  Spring Data JPA 结合 QueryDsl 快速查询
- 基础查询接口封装

