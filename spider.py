import urllib2,re
def getsubpage(url):
    replaceTab = [("&lt;","<"),("&gt;",">"),("&amp;","&"),("&amp;","\""),("&nbsp;"," "),("&copy;","C")]
    subhtml=urllib2.urlopen(url).read()
    subcontent=subhtml
    subfindre=re.compile(r'<P .*?>(.*?)</P>', re.S)
    ans=""
    newpattern=re.compile(r'<.*?>')
    for y in subfindre.findall(subcontent):
         text=newpattern.sub('',y)
         for i in replaceTab:
             text=text.replace(i[0],i[1])
         ans+=text
    return ans

def getpage(url):
    html=urllib2.urlopen(url).read()
    content=html
    findre=re.compile('<A href=(/cs/xyxw.*?) target=_blank>(.*?)</A>', re.S)
    ans=""
    for x in findre.findall(content):
        ans+=x[1]+'\n'
        ans+=getsubpage('http://cs.scu.edu.cn'+x[0])
        ans+='\n'
    return ans


def application(environ, start_response):
    start_response('200 ok', [('content-type', 'text/plain;charset=gb2312')])
    ans=getpage('http://cs.scu.edu.cn/cs/xyxw/H9501index_1.htm/')
    ans=ans.decode('gbk').encode('utf-8')
    return [ans]
