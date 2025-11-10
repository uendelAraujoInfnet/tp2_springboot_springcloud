FROM ubuntu:24.04

# Evita prompts interativos no apt
ENV DEBIAN_FRONTEND=noninteractive

# Atualiza pacotes e instala o MySQL Server
RUN apt-get update && \
    apt-get install -y mysql-server && \
    rm -rf /var/lib/apt/lists/*

# Configura o MySQL para aceitar conexões de fora do container (0.0.0.0)
RUN sed -i 's/127.0.0.1/0.0.0.0/' /etc/mysql/mysql.conf.d/mysqld.cnf || true

# Expõe a porta padrão do MySQL
EXPOSE 3306

# Comando padrão: iniciar o servidor MySQL
CMD ["mysqld_safe"]

