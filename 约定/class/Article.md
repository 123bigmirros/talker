# TypeVariety
| 值 | 用途 | 
|:----:|:----:|
| 获取个人文章 | 0 |
| 获取文章 | 1 |
| 删除文章 | 2 |
| 获取文章标签 | 3 |
# 查看个人文章
## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 0 |
|From| long | UId |
|to| long | null |
|content| String | **GetRange** |

## receive
## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 0 |
|From| long | UId |
|to| long | null |
|content| String | **List<Article>** |

# 文章获取


## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 1 |
|From| long | UId |
|to| long | null |
|content| String | **GetRange** |

## response
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 1 |
|From| long | UId |
|to| long | null |
|content| String | **List<Article>** |



# 删除已发布文章

## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 2 |
|From| long | UId |
|to| long | null |
|content| String | **deleteRange** |

