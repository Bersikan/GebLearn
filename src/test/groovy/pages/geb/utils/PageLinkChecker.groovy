package pages.geb.utils

class PageLinkChecker {

    static List<Map<String, Integer>> collectBrokenLinks(List<String> urlList) {
        List<Map<String, Integer>> linksAndResponses = []
        List<Map<String, Integer>> brokenLinks = []
        urlList.forEach {
            linksAndResponses.add([link: "${it}", code: getLinkResponseCode(it)])
        }
        brokenLinks.addAll(linksAndResponses.findAll { it.get("code") != 200 })
        return brokenLinks
    }


    static int getLinkResponseCode(String link) {
        URL url = new URL(link)
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection()
        httpURLConnection.setConnectTimeout(5000)
        httpURLConnection.connect()
        int responseCode = httpURLConnection.getResponseCode()
        return responseCode
    }


}
