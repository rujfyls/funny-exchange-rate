<h1>Funny Exchange Rate</h1>


__________________________________________________

<h5>Данный проект представляет из себя сервис, который обращается к сервису курсов валют, и отображает gif: <br>
• если курс по отношению к USD за сегодня стал выше вчерашнего, то отдаст рандомную отсюда https://giphy.com/search/rich <br>
• если ниже - отсюда https://giphy.com/search/broke </h5>
Данный сервис работает на порту: 8080
<br>
Его можно протестировать загрузив docker image: <h6> docker pull rujfyls/exchange-rate:latest </h6>
Запуск: <h6> docker run -ti --rm -p 8080:8080 rujfyls/exchange-rate:latest </h6>


---------------------------------------------------

**Использование**
<br><br>
GET method:  `/exchanger` <br>
<br>
**Результат**
<br>

![result](https://user-images.githubusercontent.com/86868993/171135330-ba394d8a-dd02-4ce0-b276-686c6d768542.png)

или

![result2](https://user-images.githubusercontent.com/86868993/171135664-b01f1f47-db7a-4ace-ae09-eb47d5af0293.png)


--------------------------------------------------------
