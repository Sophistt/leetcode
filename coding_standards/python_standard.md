## 命名规范

### 变量和函数
- 使用小写字母和下划线：`user_name`, `get_user_info()`
- 避免单字母变量名（除了循环计数器）
- 使用描述性名称

### 类名
- 使用 PascalCase：`UserManager`, `DatabaseConnection`

### 常量
- 使用全大写和下划线：`MAX_CONNECTIONS`, `DEFAULT_TIMEOUT`

## 代码风格

### 缩进
- 使用 4 个空格缩进
- 不使用 Tab

### 行长度
- 每行不超过 120 个字符
- 长表达式使用括号换行

### 空行
- 类定义之间空 2 行
- 函数定义之间空 1 行
- 逻辑块之间空 1 行

## 注释规范

### 文档字符串
```python
def calculate_total(items: list) -> float:
    \"\"\"
    计算商品总价

    Args:
        items: 商品列表

    Returns:
        总价格
    \"\"\"
    pass
```

### 行内注释
- 使用 `#` 开头
- 与代码之间至少 2 个空格

## 错误处理

- 使用具体的异常类型，避免 `except Exception`
- 必须记录异常信息
- 不要忽略异常

```python
try:
    result = risky_operation()
except ValueError as e:
    logger.error(f"Invalid value: {e}")
    raise
```

## 安全规范

- 不要在代码中硬编码密码、API key
- 使用参数化查询防止 SQL 注入
- 验证所有用户输入
- 使用 HTTPS 传输敏感数据

## 性能规范

- 避免在循环中进行数据库查询
- 使用列表推导式而不是 `map()`/`filter()`
- 及时关闭文件和数据库连接
- 使用生成器处理大数据集

## 测试规范

- 每个函数都应该有单元测试
- 测试覆盖率不低于 80%
- 使用有意义的测试名称：`test_user_login_with_invalid_password`
