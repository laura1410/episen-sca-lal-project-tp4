FROM node:12.16.1-alpine As builder

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /usr/src/app

RUN chown -R appuser /usr/src/app

USER appuser

COPY . .

RUN npm install && npm run build --prod


FROM nginx:1.15.8-alpine

COPY --from=builder /usr/src/app/dist/app/ /usr/share/nginx/html

LABEL multi.version="1.0" multi.description="Angular Frontend App" multi.maintainer="lalves1410"
LABEL exposed-url="http://localhost:80"
