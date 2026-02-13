# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## 项目概述

这是一个 Java 语言的 LeetCode 题解仓库，按照算法类型组织代码。所有题解使用中文注释说明题目要求。

## 代码结构

```
java/src/
├── leetcode/           # LeetCode 题解（按类型分类）
│   ├── arrays/         # 数组相关题目
│   ├── string/         # 字符串相关题目
│   ├── doubleptrs/     # 双指针相关题目
│   ├── dynamicprogramming/  # 动态规划题目
│   └── tobesorted/     # 待分类的题目
├── utils/              # 通用数据结构
│   └── ListNode.java   # 链表节点定义
├── tree/               # 树相关工具类
│   ├── TreeNode.java   # 二叉树节点定义
│   ├── MultiTreeNode.java  # 多叉树节点定义
│   └── BreadthFirstSearch.java  # BFS 工具类
└── DesignMode/         # 设计模式示例
```

## 命名规范

- **题解文件**: `Solution_<题号>.java`（例如：`Solution_238.java` 对应 LeetCode 第 238 题）
- **包名**: 与目录结构对应（例如：`package leetcode.arrays;`）
- **类名**: 与文件名一致

## 开发工作流

### 编译和运行单个题解

由于没有构建系统，使用标准 Java 命令：

```bash
# 编译单个文件（从项目根目录）
javac -d out java/src/leetcode/arrays/Solution_238.java

# 运行（如果有 main 方法）
java -cp out leetcode.arrays.Solution_238
```

### 编译包含依赖的题解

如果题解使用了 `utils` 或 `tree` 中的类：

```bash
# 先编译依赖
javac -d out java/src/utils/ListNode.java
javac -d out java/src/tree/TreeNode.java

# 再编译题解
javac -cp out -d out java/src/leetcode/doubleptrs/DoublePtrsForLinkedList.java
```

### 添加新题解

1. 确定题目类型，选择对应目录（arrays/string/doubleptrs/dynamicprogramming）
2. 如果不确定分类，先放入 `tobesorted/`
3. 创建 `Solution_<题号>.java` 文件
4. 文件开头添加中文注释说明题目要求和示例
5. 实现解法，必要时添加 `main` 方法用于测试

### 题目分类指南

- **arrays**: 数组操作、区间问题、前缀和等
- **string**: 字符串处理、模式匹配等
- **doubleptrs**: 双指针技巧（数组、链表、字符串）
- **dynamicprogramming**: 动态规划问题
- **tobesorted**: 新题目或难以分类的题目（如 BFS/DFS、图论等）

## 通用数据结构

### ListNode (utils/ListNode.java)
```java
package utils;
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
```

### TreeNode (tree/TreeNode.java)
```java
package tree;
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) { ... }
}
```

### MultiTreeNode (tree/MultiTreeNode.java)
用于 N 叉树问题。

## 代码风格

- 使用中文注释说明题目要求和解题思路
- 保持代码简洁，专注于算法实现
- 对于复杂算法，在关键步骤添加注释
- 变量命名使用英文，注释使用中文
