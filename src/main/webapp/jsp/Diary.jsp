<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<body>
<div class="container">
<c:forEach items="${diaries}" var="d"> 
<div class="diary">
<div class="row">
   <div class="col-lg-4 col-md-4 col-sm-12">
   <img src="/images/${d.id}.png"class="img-fluid" />
   
   </div>
   <div class="col-lg-8 col-md-8 col-sm-12 desc">
     
    <h3>Written on ${d.date}</h3>
    <p class="show-read-more">
     ${d.description}
      <form action="/diary/${d.id}" ><button type="submit" class="btn btn-primary btn-sm">Read more... </button></form>
    </p>
   </div>
  </div>
  </div>
   <hr style="border: 0.7px solid  #999;">
  
  </c:forEach>
  
  </div>

<%@ include file="common/footer.jsp"%>

</body>
</html>