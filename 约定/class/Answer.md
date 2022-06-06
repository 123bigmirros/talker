| 值 | 用途 | 
|:----:|:----:|
| 获取自身回答 | 0 |
| 获取回答 | 1 | 
| 删除回答 | 2 |


# 个人回答查看
## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 4 |
|TypeVariety| int | 1 |
|From| long | UId |
|to| long | null |
|content| String | **GetRange** |

## receive
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 1 |
|From| long | UId |
|to| long | null |
|content| String | **List<Answer>** |

# 回答查看

## send 
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 1 |
|From| long | UId |
|to| long | null |
|content| String | **GetRange** |

## receive
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 1 |
|From| long | UId |
|to| long | null |
|content| String | **List<Answer>** |


# 回答删除
## send
| 名称 | 类型 | 值 |
|:----:|:----:|:----:|
|Type| int | 3 |
|TypeVariety| int | 2 |
|From| long | UId |
|to| long | null |
|content| String | **DeleteRange** |





