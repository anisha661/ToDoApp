<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>

<div class="container">
   <div class="card mb-3">
                    <img class="card-img-top" src="/images/${diary.id}.png" >
                    <p class="card-block">
                    Written on ${diary.date }
                     <a type="button" class="btn btn-success" href="/update-diary?id=${diary.id}" style="float:right;">Edit</a>                    
                    </p>
                    <div class="card-text">
                    ${diary.description } 
                   
                     </div>
                </div>
      
</div>


<%@ include file="common/footer.jsp"%>