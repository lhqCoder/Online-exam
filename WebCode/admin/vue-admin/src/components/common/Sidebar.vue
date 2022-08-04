<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            background-color="#324157"
            text-color="#bfcbd9"
            active-text-color="#20a0ff"
            unique-opened
            router
        >
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu
                                v-if="subItem.subs"
                                :index="subItem.index"
                                :key="subItem.index"
                            >
                                <template slot="title">{{ subItem.title }}</template>
                                <el-menu-item
                                    v-for="(threeItem,i) in subItem.subs"
                                    :key="i"
                                    :index="threeItem.index"
                                >{{ threeItem.title }}</el-menu-item>
                            </el-submenu>
                            <el-menu-item
                                v-else
                                :index="subItem.index"
                                :key="subItem.index" 
                            >{{ subItem.title }}</el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from '../common/bus';
export default {
    data() {
        return {
            collapse: false,
            items: [
                {
                    icon: 'el-icon-lx-home',
                    index: 'dashboard',
                    title: '系统首页'
                },
                {
                    icon: 'el-icon-lx-cascades',
                    index: '1',
                    title: '系统管理',
                    subs: [
                        {
                            index: '1-1',
                            title: '用户管理',
                            subs: [
                                {
                                    index: 'editor',
                                    title: '管理用户'
                                },
                                {
                                    index: 'markdown',
                                    title: '学生用户'
                                }
                            ]
                        },
                        {
                            index: 'markdown',
                            title: '系统配置'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '2',
                    title: '校区管理',
                    subs: [
                        {
                            index: 'editor',
                            title: '校区列表'
                        },
                        {
                            index: 'editor',
                            title: '角色列表'
                        },
                        {
                            index: 'editor',
                            title: '权限列表'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '3',
                    title: '班级管理',
                    subs: [
                        {
                            index: 'editor',
                            title: '班级列表'
                        },
                        {
                            index: 'editor',
                            title: '班级详情'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '4',
                    title: '科目管理',
                    subs: [
                        {
                            index: 'editor',
                            title: '科目列表'
                        },
                        {
                            index: 'editor',
                            title: '科目详情'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '5',
                    title: '题库管理',
                    subs: [
                        {
                            index: 'editor',
                            title: '题目列表'
                        },
                        {
                            index: 'editor',
                            title: '题目导入'
                        },
                        {
                            index: '5-3',
                            title: '题目创建',
                            subs: [
                                {
                                    index: 'editor',
                                    title: '单选题'
                                },
                                {
                                    index: 'markdown',
                                    title: '多选题'
                                },
                                {
                                    index: 'markdown',
                                    title: '判断题'
                                },
                                {
                                    index: 'markdown',
                                    title: '填空题'
                                },
                                {
                                    index: 'markdown',
                                    title: '简答题'
                                }
                            ]
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '6',
                    title: '卷库管理',
                    subs: [
                        {
                            index: 'editor',
                            title: '试卷列表'
                        },
                        {
                            index: 'editor',
                            title: '人工组卷'
                        },
                        {
                            index: 'editor',
                            title: '智能组卷'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '7',
                    title: '答卷管理',
                    subs: [
                        {
                            index: 'editor',
                            title: '试卷列表'
                        },
                        {
                            index: 'editor',
                            title: '试卷分析'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '8',
                    title: '作业管理',
                    subs: [
                        {
                            index: 'tabs',
                            title: '作业列表'
                        },
                        {
                            index: 'tabs',
                            title: '发布作业'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '9',
                    title: '知识库管理',
                    subs: [
                        {
                            index: 'tabs',
                            title: '文档列表'
                        },
                        {
                            index: 'tabs',
                            title: '文档上传'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '10',
                    title: '课程学习',
                    subs: [
                        {
                            index: 'tabs',
                            title: '课程列表'
                        },
                        {
                            index: 'tabs',
                            title: '课程分析'
                        },
                        {
                            index: 'tabs',
                            title: '课程评论'
                        },
                        {
                            index: 'tabs',
                            title: '课程订单'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '11',
                    title: '报表中心',
                    subs: [
                        {
                            index: 'tabs',
                            title: '年纪统计'
                        },
                        {
                            index: 'tabs',
                            title: '学科统计'
                        },
                        {
                            index: 'tabs',
                            title: '班级统计'
                        },
                        {
                            index: 'tabs',
                            title: '题目统计'
                        },
                        {
                            index: 'tabs',
                            title: '试卷统计'
                        },
                        {
                            index: 'tabs',
                            title: '课程统计'
                        },
                        {
                            index: 'tabs',
                            title: '知识库统计'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '12',
                    title: '消息管理',
                    subs: [
                        {
                            index: 'tabs',
                            title: '消息列表'
                        },{
                            index: 'tabs',
                            title: '消息发送'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '13',
                    title: '日志管理',
                    subs: [
                        {
                            index: 'tabs',
                            title: '日志列表'
                        }
                    ]
                },
                {
                    icon: 'el-icon-lx-copy',
                    index: '14',
                    title: '个人中心',
                    subs: [
                        {
                            index: 'tabs',
                            title: '个人资料'
                        },
                        {
                            index: 'tabs',
                            title: '操作记录'
                        },
                        {
                            index: 'tabs',
                            title: '修改资料'
                        }
                    ]
                },
            ]
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path.replace('/', '');
        }
    },
    created() {
        // 通过 Event Bus 进行组件间通信，来折叠侧边栏
        bus.$on('collapse', msg => {
            this.collapse = msg;
            bus.$emit('collapse-content', msg);
        });
    }
};
</script>

<style scoped>
.sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
    width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
}
.sidebar > ul {
    height: 100%;
}
</style>
