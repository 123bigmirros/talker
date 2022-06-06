# TypeVariety
| 值 | 用途 | 
|:----:|:----:|
| 0 | 登录/注册 |
| 1 | 个人信息查看 |
| 2 | 修改个人信息 |
| 3 | 通过ID获取用户名称 |
# 登录/注册

## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 1 |
|TypeVariety| int | 0 |
|From| long | UId |
|to| long | null |
|content| String | null |

---

# 修改个人信息

## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 1 |
|TypeVariety| int | 1 |
|From| long | UId |
|to| long | null |
|content| string | **User** |



---

# 个人信息查看
## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 1 |
|TypeVariety| int | 2 |
|From| long | UId |
|to| long | TId |
|content| String | null |

## response 
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 1 |
|TypeVariety| int | 2 |
|From| long | UId |
|to| long | null |
|content| string | **User** |
---