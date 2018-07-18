/**
 * 
 */
/**
 * @author Wing
 *
 */
package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.lingnan.service.RoomService;
import cn.edu.lingnan.dto.Room;


public class UserServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {

	static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setCharacterEncoding("gb2312");
		try {
			start(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("gb2312");
		try {
			start(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void start(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=gb2312");
		RoomService service = new RoomService();
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		/**
		 * 添加
		 */
		if (action.equals("add")) {
			response.setContentType("text/html;charset=gb2312");
			String Rid = request.getParameter("Rid");
			String Rtype = request.getParameter("Rtype");
			String Breakfirst = request.getParameter("Breakfirst");
			String Price = request.getParameter("Price");
            Room b = new Room();
			b.setRid(Rid);
			b.setRtype(Rtype);
			b.setBreakfirst(Breakfirst);
			b.setPrice(Price);
			RoomService roomService = new RoomService();
			try {
				roomService.add(b);
				PrintWriter out = response.getWriter();
				out.print("添加成功");
			} catch (SQLException e) {
				PrintWriter out = response.getWriter();
				out.print("添加失败");
				e.printStackTrace();
			}
			request.getRequestDispatcher("/Add.jsp").forward(request, response);
		}
		/**
		 * 查詢
		 */
		else if (action.equals("list")) {
					try {
							List<Room> roomList = service.fill();
							request.setAttribute("roomList", roomList);
							request.getRequestDispatcher("/Check.jsp").forward(
									request, response);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				} else if (action.equals("list2")) {
					String id1 = request.getParameter("id");
					try {
							Room room = service.fill(id1);
							request.setAttribute("room", room);
							request.getRequestDispatcher("Check.jsp").forward(
									request, response);
						} catch (Exception e) {
							e.printStackTrace();
						}
				}
		/**
		 * 修改
		 */				
				else if (id != null&&action.equals("update")) {
							try {
									Room roomChange = service.fill(id);
									request.setAttribute("roomChange", roomChange);
									request.getRequestDispatcher("/Change.jsp").forward(
											request, response);
								} catch (Exception e) {
									e.printStackTrace();
								}
						} else if(action.equals("update2")){
							String Rid = request.getParameter("Rid");
							String Rtype = request.getParameter("Rtype");
							String Breakfirst = request.getParameter("Breakfirst");
							String Price = request.getParameter("Price");
								Room b = new Room();
								b.setRid(Rid);
								b.setRtype(Rtype);
								b.setBreakfirst(Breakfirst);
								b.setPrice(Price);
								RoomService roomService = new RoomService();
								try {
										roomService.update(b);
										PrintWriter out = response.getWriter();
										out.print("修改成功");
										
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}				
						}
		/**
		 * 删除
		 */
					 if(action.equals("delete")) {
						 try {							
							List<Room> roomDelete = service.fill();
							request.setAttribute("roomDelete", roomDelete);
							request.getRequestDispatcher("/Delete.jsp").forward(
									request, response);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  }
					  else if(action.equals("delete2")) {
						  String[] ids=request.getParameterValues("rid");
						 // String id1=request.getParameter("id");
						  try {
							//service.delete(id1);
							service.delete(ids);
							  response.sendRedirect("RoomServlet?action=delete2");
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  }
					  else if(action.equals("delete3")) {						  
						  String id1=request.getParameter("id");
						  System.out.println(id1);
						  try {							
							service.delete(id1);
							request.getRequestDispatcher("/Delete.jsp").forward(
									request, response);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  }
					
			}
}