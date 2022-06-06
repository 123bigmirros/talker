# TypeVariety
| 值 | 用途 | 
|:----:|:----:|
| 文章发送 | 0 |
| 文章修改 | 1 |
| 文章获取 | 2 |
| 文章删除 | 3 |
| 回答修改 | 4 | 
| 获取未通过的文章 | 5 |


# GetRange相关Type
| 值 | 用途 |
|:----:|:----:|
| 通过Id获取文章| 2 |
| 通过range获取文章 | 3 |

# 任务/想法发布

## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 2 |
|TypeVariety| int | 0 |
|From| long | UId |
|to| long | null |
|content| string | **UndoArticle** |



---
# 修改未通过的文章
## send 
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 2 |
|TypeVariety| int | 1 |
|From| long | UId |
|to| long | null |
|content| string | **UndoArticle** |

---
# 获取正在审批/未通过的文章

## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 2 |
|TypeVariety| int | 2 |
|From| long | UId |
|to| long | null |
|content| string | **GetRange** |

```
GetRange
Type = 2//通过文章ID获取
Type = 3//通过范围获取
```
## receive
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 2 |
|TypeVariety| int | 2 |
|From| long | UId |
|to| long | null |
|content| string | **List<UndoArticle>** |

# 文章删除
## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 2 |
|TypeVariety| int | 3 |
|From| long | UId |
|to| long | null |
|content| string | **DeleteRange** |



# 已通过文章修改
## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 2 |
|TypeVariety| int | 4 |
|From| long | UId |
|to| long | null |
|content| string | **UndoArticle** |













