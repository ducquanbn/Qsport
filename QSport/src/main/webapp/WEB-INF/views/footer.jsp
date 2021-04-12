<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>



 <!-- Scripts -->
<script src='<c:url value="/resources/js/jquery.min.js" />'></script>
<script src='<c:url value="/resources/js/popper.min.js" />'> </script>
<script src='<c:url value="/resources/js/bootstrap.min.js" />'> </script>
<script src='<c:url value="/resources/js/jquery.easing.min.js" />'> </script>
<script src='<c:url value="/resources/js/swiper.min.js" />'> </script>
<script src='<c:url value="/resources/js/wow.min.js" />'> </script>
<script>
      new WOW().init();

      //<![CDATA[
      $(window).bind("load", function() {
          jQuery("#status").delay(200).fadeOut();
          jQuery("#loader").delay(200).fadeOut();
      });
      //]]>
</script>	
<script src='<c:url value="/resources/js/scripts.js" />'> </script>
  
<script type='text/javascript'>
	$(function(){
		$(window).scroll(function(){
			if($(this).scrollTop()!=0){
				$("#noop-top").fadeIn()
				}else{
					$("#noop-top").fadeOut()
				}
			});
		$("#noop-top").click(function(){$("body,html").animate({scrollTop:0},800);
	return false})});
</script>
<a id='noop-top' style='display: none; position: fixed; bottom: 1px; right:1%; cursor:pointer;font:12px arial;'>
<img height="100px" width="100px" src='http://localhost:8080/QSport/resources/images/top.png'/></a>
<div style="background-color :#FF8840">
	<div class="container" id="foot">
		<div class="row">
			<div class=" col-lg-6">
				<p> <h4>QSport - Cửa hàng giày thể thao tốt nhất Việt Nam</h4>  </p>
				<P> ${QSport.getMoTa()}</P>
			</div>
			<div class=" col-lg-2">
				<p> <h4>Số điện thoại</h4>  </p>
				<P> ${QSport.getSdt()}</P>
			</div>
			<div class=" col-lg-2">
				<p> <h4>Địa chỉ</h4>  </p>
				<P> ${QSport.getDiaChi()}</P>
			</div>
			<div class=" col-lg-2">
				<p> <h4>Email</h4>  </p>
				<P> ${QSport.getEmail()}</P>
			</div>
		</div>
		<div> <img  style="height: 50px; width: 150px" alt="payment" src="http://localhost:8080/QSport/resources/images/20150827110756-dathongbao-600x228.png"> </div>
		<div> <p align="center"> <b> &copy; Nguyễn Đức Quân</b>  </p> </div>
	</div>
</div>
