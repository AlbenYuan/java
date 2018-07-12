# Shiro
安全框架

- SecurityManager: 管理器

- Realm: 域、范围， 验证信息的来源的范围和获取方式

- Subject:  主题，验证用户的主体。

- Token: 凭证，可以获取到的用户的凭证类型，和凭证内容，用于Subject去做校验。



## 认证过程

1. 构建SecurityManager环境

2. 主题提交认证请求

3. 