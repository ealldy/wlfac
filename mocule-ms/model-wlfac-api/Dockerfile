FROM registry.htres.cn/yunlu/jdk8-alpine:latest

# 压缩文件解压路径
ENV RUN_PREFIX  /opt

# APP名字
ENV APP_NAME model-wlfac-api

# TAR包名称
ENV TAR_FILE_NAME model-wlfac-api-0.0.1-SNAPSHOT

# 创建文件夹
RUN mkdir -p ${RUN_PREFIX}

# 将压缩文件解压至 RUN_PREFIX
ADD build/distributions/${TAR_FILE_NAME}.tar ${RUN_PREFIX}

# 切换至 APP_NAME 目录下
WORKDIR ${RUN_PREFIX}/${TAR_FILE_NAME}

ENV ENV_CONFIG release

# 启动命令
CMD ["sh", "-c", "./bin/${APP_NAME}"]