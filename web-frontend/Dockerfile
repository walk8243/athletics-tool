FROM node:18 AS builder

WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm ci

COPY . .
RUN npm run build

FROM node:18

WORKDIR /usr/app

ENV NODE_ENV=production

RUN groupadd nodejs && useradd --no-create-home --no-user-group --groups nodejs nextjs

COPY --from=builder --chown=nextjs:nodejs /usr/src/app/public ./public
COPY --from=builder --chown=nextjs:nodejs /usr/src/app/.next/standalone ./
COPY --from=builder --chown=nextjs:nodejs /usr/src/app/.next/static ./.next/static

USER nextjs

CMD ["node", "server.js"]
